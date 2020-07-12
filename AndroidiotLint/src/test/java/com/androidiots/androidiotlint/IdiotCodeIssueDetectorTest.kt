package com.androidiots.androidiotlint

import com.android.annotations.NonNull
import com.android.testutils.TestUtils
import com.android.tools.lint.checks.infrastructure.LintDetectorTest.xml
import com.android.tools.lint.checks.infrastructure.TestLintTask
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test
import java.io.File


/**
 * @author Anupam Singh
 * @since 13/07/20
 */

class IdiotCodeIssueDetectorTest {


    @Test
    fun testRadioButton() {


            lint()?.files(
                xml(
                    "res/layout/layout.xml",
                    """
                <merge>
                <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            />
</merge>
            """
                ).indented()
            )
                ?.issues(IdiotCodeIssueDetector.ISSUE)
                ?.run()
                ?.expectWarningCount(1)
                ?.verifyFixes()
                ?.checkFix(
                    null,
                    xml(
                        "res/layout/layout.xml",
                        """
                <merge>
                     <com.androidiots.playground.IdiotRadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
                </merge>
            """
                    ).indented()
                )


    }


}