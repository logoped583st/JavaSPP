class StateMacine {

    private val history: List<State> = ArrayList()

    fun enterEvent(state: State, actions: Actions) {
        when (actions) {
            is Actions.RollBack -> {

            }
            is Actions.Save -> {

            }
            is Actions.PushEvent -> {

            }
        }
    }
}



abstract class State() {
    abstract val state: State
}

sealed class Actions {
    object RollBack : Actions()
    object Save : Actions()
    object PushEvent : Actions()
}


