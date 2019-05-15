import java.util.*

object StateMacine {

    private val history: Stack<State> = Stack()

    fun getLastState(): State? = history.lastOrNull()

    init {
        InitState()
    }

    fun enterEvent(state: State, actions: Actions) {
        when (actions) {
            is Actions.RollBackLast -> {
                if (history.size > 1) {
                    history.pop()
                }
            }
            is Actions.Save -> {
                history.clear()
                history.push(state)
            }
            is Actions.Change -> {
                history.push(state)
            }
            is Actions.Init -> {
                history.push(state)
            }
            is Actions.RollBackAll -> {
                val story = history.firstElement()
                history.clear()
                history.push(story)
            }
        }
        println(actions)
    }

}

class Save : State {

    override var fileText: String = StateMacine.getLastState()?.fileText ?: ""

    init {
        StateMacine.enterEvent(this, Actions.Save)
    }


}

class ChangeFile(val changeFor: String) : State {
    override var fileText: String = StateMacine.getLastState()?.fileText ?: ""

    init {
        fileText = changeFor
        StateMacine.enterEvent(this, Actions.Change)
    }

}

class InitState : State {

    override var fileText: String = "init file"

    init {
        StateMacine.enterEvent(this, Actions.Init)
    }
}

class RoleBackAll : State {
    override var fileText: String = StateMacine.getLastState()?.fileText ?: ""

    init {
        StateMacine.enterEvent(this, Actions.RollBackAll)
    }
}

class RoleBack : State {
    override var fileText: String = StateMacine.getLastState()?.fileText ?: ""

    init {
        StateMacine.enterEvent(this, Actions.RollBackLast)
    }
}

interface State {
    var fileText: String
}

sealed class Actions {
    object RollBackAll : Actions()
    object RollBackLast : Actions()
    object Save : Actions()
    object Change : Actions()
    object Init : Actions()
}


