
fun main(EilenFonseca: Array<String>){
  val word="EILEN" //puedes cambiar la palabra por la que quieras mientras no exceda 6 caracteres
  val list=word.toCharArray(). toMutableList()
  val permList=permute(list)
  val distPerList=permList.distinct()
  println("Hay ${distPerList.size} permutaciones de $word :\n")
  for(perm in distPerList) 
     println(perm.joinToString(""))
}
fun <String> permute(list:List <String>):List<List<String>>{
  if(list.size==1) return listOf(list)
  val perms=mutableListOf<List <String>>()
  val sub=list[0]
  for(perm in permute(list.drop(1)))
   for (i in 0..perm.size){
     val newPerm=perm.toMutableList()
     newPerm.add(i,sub)
     perms.add(newPerm)
   }
  return perms
}