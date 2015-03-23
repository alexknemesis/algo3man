# Introducción #

Quería poner más o menos como se me ocurrió los criterios del mapa en relación a las celdas

# Detalles #

Las posiciones de las celdas difieren de las posiciones absolutas de los objetos móviles, es decir: los fantasmas y el pacman se mueven por un mapa con una definición mucho más grande que las celdas, el mapa puede tener 31x28 celdas, pero los _Personajes_ se mueven en un múltiplo superior de esos números, por ejemplo 310x280, o lo que sea, se me ocurrió que las celdas tengan un _Centro_ y que las velocidades de los personajes, o sea la diferencia de posiciones absolutas por llamada del **vivir()** tenga que pasar por ese centro, para simplificar las cosas, de lo contrario vamos a tener que determinar un "área" de referencia para cambiar de posición...