package Práctica_3.tester;

import java.util.*;
import Práctica_3.elemcomida.*;

public class MenuTester2 extends PlatosTester2 {
    private static List<Menu> menus = new ArrayList<>();

    public static void main(String[] args) {
        MenuTester2 tester = new MenuTester2();
        for (Menu menu : tester.crearMenus())
            System.out.println("* " + menu);
    }

    public List<Menu> crearMenus() {
        Map<String, Plato> platos = this.crearPlatos();
        Menu m1 = new Menu(platos.get("Arroz con pollo"), platos.get("Ensalada"));
        Menu m2 = new Menu(platos.get("Sopa"));
        return Arrays.asList(m1, m2);
    }
    public static List<Menu> getMenus() {
        return menus;
    }

}

