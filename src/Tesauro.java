import java.util.*;

public class Tesauro {
    HashMap<String, ArrayList<String>> diccionario = new HashMap<>();


    public Tesauro() {

    }

    public void añadirSinonimo(String palabra, String sinonimo) {
        ArrayList<String> arr = diccionario.get(palabra);

        if (arr == null) {
            arr = new ArrayList<>();
            arr.add(sinonimo);
            diccionario.put(palabra, arr);
        } else {
            arr.add(sinonimo);
            diccionario.put(palabra, arr);
        }
    }

    public void añadirSinonimo(String cadena) {
        String[] palabras = cadena.split("\\s+");
        String palabra = palabras[0];

        ArrayList<String> arr = diccionario.get(palabras[0]);

        if (arr == null) {
            arr = new ArrayList<>();
            for (int i = 1; i < palabras.length; i++) {
                arr.add(palabras[i]);
            }
            diccionario.put(palabra, arr);

        } else {
            for (int i = 1; i < palabras.length; i++) {
                arr.add(palabras[i]);
            }
            diccionario.put(palabra, arr);
        }
    }

    public HashSet<String> borrarSinonimo(String sinonimo) {
        HashSet<String> clavesSinonimoBorrado = new HashSet<>();

        Iterator<Map.Entry<String, ArrayList<String>>> iter = diccionario.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry entry = iter.next();
            ArrayList<String> arr = (ArrayList<String>) entry.getValue();
            if (arr.contains(sinonimo)){
                clavesSinonimoBorrado.add(entry.getKey().toString());
                arr.remove(sinonimo);
                diccionario.put(entry.getKey().toString(), arr);
            }

        }
        return clavesSinonimoBorrado;
    }

    public String toString() {
        return diccionario.toString();
    }
}
