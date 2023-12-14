package classes.android.solidPrinciples

/** Liskov Substitution Principle */

//Problem
//There might be subclasses of Report that don't behave as expected,
//potentially leading to errors in the system.

//Solution
//Ensure that subclasses of Report don't violate the expectations of the base class.
//In this case, both FinancialReport and DummyReport adhere to the contract of the Report interface.

interface Report_ {
    fun generate(): String
}

class FinancialReport_ : Report {
    override fun generate(): String {
        // Financial report generation logic
        return "Financial Report"
    }
}

class DummyReport : Report {
    override fun generate(): String {
        // Dummy report generation logic
        return "Dummy Report"
    }
}

class ReportSaver_ {
    fun saveReportToFile(report: Report) {
        // Save report to file logic
        println("Saved ${report.generate()} to file")
    }
}