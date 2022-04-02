
//RESPUESTAS
const val respGuardado="Guardado Exitosamente"
const val respElim="Se eliminó correctamente"
const val salir="Regresa pronto"
const val respCompletado="Tarea realizada"
const val respMedias="Ya vas a la mitad"

//Uniendo respuestas con estados
val avanceRespuestas= mapOf(
    "Completa" to respCompletado,
    "Mitad" to respMedias,
)
val tareasL= mutableMapOf<String,String>()

fun main(args: Array<String>) {
   menu()
}
fun menu(){
    //Menu para el usuario
    println("\nMenu: ")
    println("1. Ver la lista de tareas\n2. Agregar una tarea\n3. Cambiar el estado de la tarea\n4. Salir")
    //Leyendo la respuesta del usuario
    val respuesta= readLine()

    //Evaluando la respuesta del usuario
    when(respuesta){
        "1"-> mostrarTareas()
        "2"-> nuevaTarea()
        "3"-> estadoTarea()
        "4"-> salir()
        else-> mensajeError()
    }
}
fun mostrarTareas(){
    println(tareasL)
    menu()

}
fun nuevaTarea(){
    println("Nombre: ")
    val name= readLine()
    if (name != null) {
        tareasL[name] = "No iniciada"
        println(respGuardado)
        menu()
    }else{
        println("Nombre de la tarea no válido\n")
        menu()
    }
}

fun estadoTarea(){
    println("Nombre de la tarea: ")
    var nametask= readLine()
    if (nametask!=null&& tareasL[nametask]!=null){
        println("Estado:\n 1. Completa\n 2. 50% avance\n ")
        val state= readLine()
        when(state){
            "1"-> {println(avanceRespuestas["Completa"])
                tareasL[nametask]="Completa"
                menu()
            }
            "2"-> {println(avanceRespuestas["Mitad"])
                tareasL[nametask]="Mitad"
                menu()
            }
            else-> {println("No existe esa opción\n")
                menu()
            }
        }
    }else{
        println("Nombre incorrecto")
        estadoTarea()
    }

}
fun salir(){
    println(salir)
}
fun mensajeError(){
    println("Opción invalida\n")
    menu()
}