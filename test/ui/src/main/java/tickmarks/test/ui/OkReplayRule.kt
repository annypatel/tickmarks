package tickmarks.test.ui

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.rule.GrantPermissionRule
import okhttp3.Interceptor
import okreplay.AndroidTapeRoot
import okreplay.MatchRules
import okreplay.OkReplayConfig
import okreplay.OkReplayInterceptor
import okreplay.RecorderRule
import okreplay.TapeMode
import org.junit.rules.RunRules
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * A Junit [TestRule] for OkReplay.
 *
 * Note: OkReplay's OkReplayRuleChain depends on ActivityTestRule. To use OkReplay with
 * FragmentScenario and ActivityScenario we need to create custom rule chain which wraps
 * [RecorderRule] (records tapes) into [GrantPermissionRule] (grant write permission on device).
 */
class OkReplayRule(testInstance: Any) : TestRule {

    private val config = OkReplayConfig.Builder()
        .tapeRoot(AndroidTapeRoot(getApplicationContext(), testInstance::class.java))
        .defaultMode(TapeMode.READ_WRITE)
        .defaultMatchRules(MatchRules.method, MatchRules.uri)
        .sslEnabled(true)
        .interceptor(OkReplayInterceptor())
        .build()

    val interceptor: Interceptor get() = config.interceptor()

    override fun apply(base: Statement, description: Description): Statement {
        val rules = listOf(
            GrantPermissionRule.grant(WRITE_EXTERNAL_STORAGE),
            RecorderRule(config)
        )
        return RunRules(base, rules, description)
    }
}
