class Main{
    companion object{
        @JvmStatic
        fun main(args:Array<String>){
            println(StateMacine.getLastState()?.fileText)
            ChangeFile("change0")
            println(StateMacine.getLastState()?.fileText)
            Save()
            println(StateMacine.getLastState()?.fileText)
            RoleBack()
            println(StateMacine.getLastState()?.fileText)
            ChangeFile("change1")
            println(StateMacine.getLastState()?.fileText)
            RoleBack()
            println(StateMacine.getLastState()?.fileText)
            ChangeFile("change2")
            println(StateMacine.getLastState()?.fileText)
            ChangeFile("change3")
            println(StateMacine.getLastState()?.fileText)
            ChangeFile("change4")
            println(StateMacine.getLastState()?.fileText)
            RoleBackAll()
            println(StateMacine.getLastState()?.fileText)
        }
    }
}


