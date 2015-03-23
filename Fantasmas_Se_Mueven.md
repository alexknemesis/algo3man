#Sobre cuando se mueven los fantasmas

# Introduction #

Tratando de solucionar mi problema sobre ver como se da cuenta la celda puerta quien lo llama descubrí un problema.


# Details #


Según el diagrama de clases cuando un fantasma hace vivir y está atacando obtiene la posición del pacman y luego obtiene la celda a la que quiere ir pregunta si es transitable.

En el vivir de los fantasmas está

this.direccion = determinarSiguienteDireccion();
this.moverseEnDireccionActual();


En la primera determinás la posición pero en el segundo movés directamente. Hay que preguntar si la "POSICIÓN TENTATIVA" es transitable.

Estaría genial que hubiera un atributo "Posición tentativa". Así puedo discriminar en el **esTransitable** de ciertas celdas quien lo llamo preguntando si la posición de la celda es igual a la tentativa.

Esto es una idea, pero lo que si hay que preguntar antes si te podés mover.