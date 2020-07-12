package com.androidiots.androidiotlint

import com.android.tools.lint.detector.api.*
import org.w3c.dom.Element

/**
 * @author Anupam Singh
 * @since 12/07/20
 */

class IdiotCodeIssueDetector : Detector(), XmlScanner {


    override fun getApplicableElements(): Collection<String> {
        return listOf("RadioButton")
    }

    override fun visitElement(context: XmlContext, element: Element) {

        val idiotRadioButtonFix = LintFix.create()
            .name("Use IdiotRadioButton")
            .replace()
            .text("RadioButton")
            .with("com.androidiots.playground.IdiotRadioButton")
            .robot(true)
            .independent(true)
            .build()

        context.report(
            issue = ISSUE,
            location = context.getNameLocation(element),
            message = "Usage of Radio Button is prohibited",
            quickfixData = idiotRadioButtonFix
        )
    }

    companion object {

        val ISSUE = Issue.create(
            id = "IdiotRadioButtonUsageWarning",
            briefDescription = "Android's RadioButton should not be used",
            explanation = "Don't use Android Radio button, be an idiot and use IdiotRadioButton instead",
            category = Category.CORRECTNESS,
            priority = 3,
            severity = Severity.WARNING,
            implementation = Implementation(
                IdiotCodeIssueDetector::class.java,
                Scope.RESOURCE_FILE_SCOPE
            )
        )
    }

}