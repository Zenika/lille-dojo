package main.java

fun main(args : Array<String>) {
    println("Hello, world!")
}

fun compute(number:Number):String {
    var result:String = ""


    if(number.toInt()%3 == 0){
        result += "foo";
    }

    if(number.toInt()%5 == 0){
        result += "bar"
    }

    if(number.toInt()%7 == 0){
        result += "qix"
    }


    if(result.isEmpty()) {
        return number.toString().replace('0', '*');
    }

    result += getSuffix(number);

    return result
}

fun getSuffix(number: Number):String
{

    var result =  number.toString()
            .replace('0', '*')
            .toCharArray()
            .map { c ->
                hashMapOf('7' to "qix", '3' to "foo", '5' to "bar", '*' to "*").getOrDefault(c, "") }



    return result.joinToString(separator = "", transform = { c -> c })
}
