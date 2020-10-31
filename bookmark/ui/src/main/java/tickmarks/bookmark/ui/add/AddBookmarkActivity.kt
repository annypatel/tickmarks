package tickmarks.bookmark.ui.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import tickmarks.bookmark.ui.R

/**
 * Activity add bookmark screen.
 */
@AndroidEntryPoint
class AddBookmarkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bookmark)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AddBookmarkFragment())
                .commit()
        }
    }
}
