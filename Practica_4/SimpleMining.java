package Practica_4;
import Practica_4.utils.*;
/*
● mineBlock(Transaction, Block, String): Realiza el minado del bloque. Esta operación crea un nuevo bloque, incluyendo
todos los datos especificados anteriormente, y le asigna el hash que retorna el método createHash.
¿Cuándo se realiza el minado?
El proceso de minado se inicia por un nodo minador, tras recibir un mensaje TransactionNotification, y comprobar que la transacción
no ha sido confirmada (recuerda que cada nodo almacena una lista de transacciones confirmadas). Dependiendo del tipo de nodo que
reciba este mensaje, el comportamiento es ligeramente diferente:
● Nodo simple: Al recibir un mensaje de tipo TransactionNotification simplemente debe ignorarlo, ya que los nodos simples no
soportan el minado de bloques.
● Nodo minador: Al recibir un mensaje de tipo TransactionNotification debe extraer la transacción del mensaje, comprobar que la
transacción no está confirmada (no está en la lista de transacciones confirmadas del nodo), y en ese caso, realizar el minado del
bloque asociado a la transacción, usando el método de minado. Por el contrario, si la transacción ya está confirmada, se descarta.*/

import Practica_4.utils.CommonUtils;

import java.util.HashMap;

public class SimpleMining implements IMiningMethod{

    public SimpleMining() {
    }
    @Override
    public String createHash(Block block){

        if(block.getPreviousBlock() == null) {
            return CommonUtils.sha256(block.getVersion() + BlockConfig.GENESIS_BLOCK + block.getTimestamp() + block.getDifficulty() + block.getNonce());
        }
        else
            return CommonUtils.sha256(block.getVersion() + block.getPreviousBlock().getHash() + block.getTimestamp() + block.getDifficulty() + block.getNonce());

    }

    @Override
    public Block mineBlock(Transaction transaction, Block previousBlock, String minerKey) {

        Block block = new Block(transaction);
        block.setPreviousBlock(previousBlock);
        block.setHash(createHash(block));
        return block;
    }

}
