package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmesMap {
    private static Map<String, String> header;
    private static Map<String, Object> filme;
    private static Map<String, Object> categoria1;
    private static Map<String, Object> categoria2;
    private static Map<String, Object> plataforma;
    private static List<Map<String, Object>> listCategoria;
    private static List<Map<String, Object>> listPlataforma;

    public static Map<String, String> getHeader() {
        return header;
    }

    public static Map<String, Object> getFilme() {
        return filme;
    }

    public static Map<String, Object> getCategoria1() {
        return categoria1;
    }

    public static Map<String, Object> getCategoria2() {
        return categoria2;
    }

    public static Map<String, Object> getPlataforma() {
        return plataforma;
    }

    public static List<Map<String, Object>> getListCategoria() {
        return listCategoria;
    }

    public static List<Map<String, Object>> getListPlataforma() {
        return listPlataforma;
    }

    public static void initCategoria(){
        listCategoria = new ArrayList<>();
        categoria1 = new HashMap<>();
        categoria2 = new HashMap<>();
        categoria1.put("tipo", "Acao");
        categoria2.put("tipo", "Comedia");
        listCategoria.add(categoria1);
        listCategoria.add(categoria2);
    }

    public static void initHeader(){
        header = new HashMap<>();
        header.put("Authorization", "Bearer "+LoginMap.token);
    }

    public static void initPlataforma(){
        listCategoria = new ArrayList<>();
        plataforma = new HashMap<>();
        plataforma.put("nome", "Netflix");
        listPlataforma.add(plataforma);
    }

    public static void initFilme(){
        filme = new HashMap<>();
        filme.put("nome", "DeadPool e Wolverine");
        filme.put("descricao", "Wolverine está se recuperando quando cruza seu caminho com Deadpool");
        filme.put("duracao", 2.25);
        filme.put("categorias", listCategoria);
        filme.put("plataformas", listPlataforma);
    }

    public static void initAll(){
        initHeader();
        initCategoria();
        initPlataforma();
        initFilme();

    }




}
