import kotlinx.coroutines.*



fun main() = runBlocking {


    val scope = CoroutineScope(Dispatchers.Default + CoroutineName("Non-Cooperative"))

    val startTime = System.currentTimeMillis()
    val job1 = scope.launch() {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                logMessage("Hello World ${i++}")
                nextPrintTime += 500L
            }
        }

    }

    delay(1000L)
    logMessage("Cancel!")
    scope.cancel()

    job1.cancel()
    logMessage("Done!")
    delay(5000)

}


// Please scroll down for completed code examples.

//isActive
/*
fun main() = runBlocking {


    val scope = CoroutineScope(Dispatchers.Default + CoroutineName("isActive"))

    val startTime = System.currentTimeMillis()
    val job1 = scope.launch() {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5 && isActive) {
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                logMessage("Hello World ${i++}")
                nextPrintTime += 500L
            }
        }

    }

    delay(1000L)
    logMessage("Cancel!")
    job1.cancel()
    logMessage("Done!")
    delay(5000)

}
*/







//ensureActive()
/*fun main() = runBlocking {


    val scope = CoroutineScope(Dispatchers.Default + CoroutineName("ensureActive"))

    val startTime = System.currentTimeMillis()
    val job1 = scope.launch() {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            ensureActive()
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                logMessage("Hello World ${i++}")
                nextPrintTime += 500L
            }
        }

    }

    delay(1000L)
    logMessage("Cancel!")
    job1.cancel()
    logMessage("Done!")
    delay(5000)

}*/





/*
//yield
fun main() = runBlocking {


    val scope = CoroutineScope(Dispatchers.Default + CoroutineName("yield"))
    val startTime = System.currentTimeMillis()
    val job1 = scope.launch() {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            yield()
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                logMessage("Hello World ${i++}")
                nextPrintTime += 500L
            }
        }

    }

    delay(1000L)
    logMessage("Cancel!")
    job1.cancel()
    logMessage("Done!")
    delay(5000)

}

*/







/*

// delay()
fun main() = runBlocking {


    val scope = CoroutineScope(Dispatchers.Default + CoroutineName("delay"))

    val startTime = System.currentTimeMillis()
    val job1 = scope.launch() {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            delay(1)
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                logMessage("Hello World ${i++}")
                nextPrintTime += 500L
            }
        }

    }

    delay(1000L)
    logMessage("Cancel!")
    job1.cancel()
    logMessage("Done!")
    delay(5000)
}

*/



fun logMessage(msg: String) {
    println("Running on: [${Thread.currentThread().name}] | $msg")
}
