package classes.android.solidPrinciples

/** Interface Segregation Principle */

//=>Problem
//Clients should not be forced to depend on interfaces they do not use.
//If a class implements an interface with methods it does not need, it is forced to provide empty or meaningless implementations.

//=>Answer
//Split large interfaces into smaller, more specific ones, so that classes can implement only the interfaces relevant to them.


interface Report__ {
    fun generate(): String
}

interface SavableReport {
    fun saveToDatabase(): Boolean
}

class FinancialReport__ : Report, SavableReport {
    override fun generate(): String {
        // Financial report generation logic
        return "Financial Report"
    }

    override fun saveToDatabase(): Boolean {
        // Save report to database logic
        println("Saved Financial Report to database")
        return true
    }
}

class DummyReport__ : Report {
    override fun generate(): String {
        // Dummy report generation logic
        return "Dummy Report"
    }
}
