package Practica_4;

/*Cuando una transacción es difundida por la red, debe ser gestionada por un nodo para ser convertida en un bloque. Este proceso se
llama minado y lo realizan los nodos minadores. Para dar soporte a bloques, crea la clase Block que define la siguiente información:
● Un identificador único de bloque.
● El número de versión. Puedes darle como valor por defecto el del campo VERSION de la clase BlockConfig, que está incluida en los
ficheros adicionales proporcionados en Moodle.
● Nonce, que es un número aleatorio entre 0 y 1000 de un solo uso, usado para evitar ataques de replicación en las comunicaciones.
● La marca temporal (timestamp) del momento en que se mina el nodo. En este tipo de entornos, el timestamp suele ser de tipo
entero. Puedes usar (int) (new Date().getTime()/1000) para un timestamp basado en los segundos transcurridos desde el año 1970.
● La dificultad de minar un bloque (que es un número). Puedes darle como valor inicial el del campo DIFFICULTY de la clase
BlockConfig.
● La transacción origen del bloque actual.
● Un flag que indica si el bloque está validado.
● El hash del bloque, que es de tipo String. Este hash debe calcularlo el nodo minador, es decir, no debe calcularse en la clase Block.
● El bloque anterior al actual, que podrá ser nulo.
Además, la clase MiningNode deberá guardar los bloques que ha validado.*/

public class Block {
}
