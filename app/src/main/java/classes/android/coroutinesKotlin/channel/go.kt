package classes.android.coroutinesKotlin.channel

import classes.android.coroutinesKotlin.context.CommonPool
import classes.android.coroutinesKotlin.run.runBlocking

fun mainBlocking(block: suspend () -> Unit) = runBlocking(CommonPool, block)

fun go(block: suspend () -> Unit) = CommonPool.runParallel(block)

