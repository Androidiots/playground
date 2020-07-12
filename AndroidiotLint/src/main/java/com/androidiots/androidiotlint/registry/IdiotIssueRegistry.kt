package com.androidiots.androidiotlint.registry

/**
 * @author Anupam Singh
 * @since 12/07/20
 */

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue
import com.androidiots.androidiotlint.IdiotCodeIssueDetector

class IdiotIssueRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            IdiotCodeIssueDetector.ISSUE
        )
}