package ar.edu.utn.frba.mobile.a2019c1

 class ConversorUnidades {

    fun celsiusToF(celsius: Double):Double= ((celsius*1.8) + 32)

    fun celsiusToK(celsius: Double):Double= (celsius+ 273.15)

    fun kelvinToC(kelvin: Double):Double= (kelvin - 273.15)

    fun kelvinToF(kelvin: Double):Double= ((kelvin - 273.15)*1.8 +32)

    fun fahToC(fah: Double):Double= ((fah - 32)/1.8)

    fun fahToK(fah: Double):Double= ((fah - 32)*0.55+273.15)
}