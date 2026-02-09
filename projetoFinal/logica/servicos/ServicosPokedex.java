package projetoFinal.logica.servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import projetoFinal.logica.dto.ElementoDTO;
import projetoFinal.logica.dto.FraquezaVantagemDTO;
import projetoFinal.logica.dto.PokedexDTO;
import projetoFinal.logica.dto.PokemonElementoDTO;
import projetoFinal.logica.dto.PokemonElementosDTO;
import projetoFinal.logica.dto.PokemonPokedexDTO;
import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.modelos.Evolucao;
import projetoFinal.logica.modelos.FraquezaVantagem;
import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.modelos.Pokedex;
import projetoFinal.logica.modelos.Pokemon;
import projetoFinal.logica.modelos.PokemonElemento;
import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.persistencia.DAO.ElementoDAO;
import projetoFinal.logica.persistencia.DAO.EvolucaoDAO;
import projetoFinal.logica.persistencia.DAO.FraquezaVantagemDAO;
import projetoFinal.logica.persistencia.DAO.JogoDAO;
import projetoFinal.logica.persistencia.DAO.PokedexDAO;
import projetoFinal.logica.persistencia.DAO.PokemonDAO;
import projetoFinal.logica.persistencia.DAO.PokemonElementoDAO;
import projetoFinal.logica.persistencia.DAO.RegiaoDAO;

public class ServicosPokedex {
    private static PokedexDAO daoPokedex = new PokedexDAO();
    private static PokemonDAO daoPokemon = new PokemonDAO();
    private static ElementoDAO daoElemento = new ElementoDAO();
    private static PokemonElementoDAO daoPokemonElemento = new PokemonElementoDAO();
    private static RegiaoDAO daoRegiao = new RegiaoDAO();
    private static JogoDAO daoJogo = new JogoDAO();
    private static FraquezaVantagemDAO daoFV = new FraquezaVantagemDAO();
    private static EvolucaoDAO daoEvolucao = new EvolucaoDAO();

    public static void criar(Pokedex obj){
        daoPokedex.inserir(obj);
    }
    public static void atualizar(Pokedex obj){
        daoPokedex.atualizar(obj);
    }
    public static Pokedex achar(Long id){
        Pokedex obj = daoPokedex.buscarPorId(id);
        return obj;
    }
    public static List<Pokedex> listar(){
        return daoPokedex.listarTodos();
    }
    public static void apagar(Long id){
        daoPokedex.deletar(id);
    }

    private static PokemonPokedexDTO criarPokemonPokedexDTO(Pokedex pokedex, Jogo jogo, Regiao regiao, Pokemon pokemon, Evolucao evolucao , 
        List<ElementoDTO> elementos)
    {
        PokemonPokedexDTO p = new PokemonPokedexDTO();
        p.setNomeJogo(jogo.getNome());
        p.setIdJogo(jogo.getId());
        p.setNomeRegiao(regiao.getNome());
        p.setNomePokemon(pokemon.getNome());
        p.setIdPokemon(pokemon.getId());
        p.setImagemPokemon(pokemon.getImagem());
        p.setCor(pokedex.getCor());
        p.setNumeroPokemon(pokedex.getNumeroPokemon());
        p.setDescricaoPokemon(pokedex.getDescricaoPokemon());
        p.setElementos(elementos);
        if (evolucao != null){
            p.setEstagio(evolucao.getEstagio());
            p.setRequisitos(evolucao.getRequisitos());
        }
        return p;
    }

    private static PokemonPokedexDTO criarPokemonPokedexDTO(long idPokedex)
    {
        Pokedex pokedex = daoPokedex.buscarPorId(idPokedex);
        Jogo jogo = daoJogo.buscarPorId(pokedex.getIdJogo());
        Regiao regiao = daoRegiao.buscarPorId(pokedex.getIdRegiao());
        Pokemon pokemon = daoPokemon.buscarPorId(pokedex.getIdPokemon());
        Evolucao evolucao = daoEvolucao.listarPorPokemon(pokemon.getId());
        List<PokemonElemento> pokemonElementos =  daoPokemonElemento.listarElementosPorPokemonJogo(pokemon.getId(), jogo.getId());
        List<ElementoDTO> elementos = new ArrayList<ElementoDTO>();
        List<FraquezaVantagemDTO> fvsDTO = new ArrayList<FraquezaVantagemDTO>();
        for (PokemonElemento pe : pokemonElementos){
            Elemento e = daoElemento.buscarPorId(pe.getIdElemento());
            ElementoDTO eDTO = new ElementoDTO();
            eDTO.setId(e.getId());
            eDTO.setImagem(e.getImagem());
            eDTO.setCor(e.getCor());
            eDTO.setNome(e.getNome());
            List<FraquezaVantagem> fvs = daoFV.listarPorElementoJogo(e.getId(), jogo.getId());
            for (FraquezaVantagem fv : fvs){
                FraquezaVantagemDTO fvDTO = new FraquezaVantagemDTO();
                Elemento eFV = daoElemento.buscarPorId(fv.getIdElementoFraquezaVantagem());
                fvDTO.setId(fv.getId());
                fvDTO.setNome(eFV.getNome());
                fvDTO.setCor(eFV.getCor());
                fvDTO.setImagem(eFV.getImagem());
                fvDTO.setEhFraqueza(fv.getEhFraqueza());
                fvDTO.setMultiplicador(fv.getMultiplicador());
                fvsDTO.add(fvDTO);
                eDTO.addVantagemFraqueza(fvDTO);
            }
            elementos.add(eDTO);
        }

        PokemonPokedexDTO p = criarPokemonPokedexDTO(pokedex, jogo, regiao, pokemon, evolucao, elementos);
        return p;
    }


    private static PokemonPokedexDTO montarPokemonPokedexDTO(long idPokedex)
    {
        PokemonPokedexDTO pokemon = criarPokemonPokedexDTO(idPokedex);

        Evolucao proximoEstagio = daoEvolucao.listarPorPokemon(pokemon.getIdPokemon());
        Evolucao anteriorEstagio = daoEvolucao.listarPorPokemonEvolucao(pokemon.getIdPokemon());
        List<PokemonPokedexDTO> proximos = new ArrayList<PokemonPokedexDTO>();
        List<PokemonPokedexDTO> anteriores = new ArrayList<PokemonPokedexDTO>();
        while (proximoEstagio != null){
            Pokedex pokedex = daoPokedex.buscarPorIdJogoPokemon(pokemon.getIdJogo(), proximoEstagio.getPokemonId());
            PokemonPokedexDTO prox = criarPokemonPokedexDTO(pokedex.getId());
            proximos.add(prox);
            proximoEstagio = daoEvolucao.listarPorPokemon(proximoEstagio.getPokemonId());

        }
        while (anteriorEstagio != null){
            Pokedex pokedex = daoPokedex.buscarPorIdJogoPokemon(pokemon.getIdJogo(), anteriorEstagio.getPokemonId());
            PokemonPokedexDTO ante = criarPokemonPokedexDTO(pokedex.getId());
            anteriores.add(ante);
            anteriorEstagio = daoEvolucao.listarPorPokemonEvolucao(anteriorEstagio.getPokemonId());
        }
        Collections.reverse(anteriores);
        anteriores.addAll(proximos);
        pokemon.setEvolucoes(anteriores);
        return pokemon;
    } 

    public static PokemonPokedexDTO acharPokemon(Long idPokedex){
        return montarPokemonPokedexDTO(idPokedex);
    }
    public static PokemonPokedexDTO listarPokemonsPorJogo(Long idJogo){
        return new PokemonPokedexDTO();
    }

    private static PokemonElementosDTO montarPokemonElementoDTO(long idPokemon, Long idJogo){
            Pokemon p = daoPokemon.buscarPorId(idPokemon);
            List<PokemonElemento> pes = ServicosPokemon.acharElementosPokemon(idPokemon, idJogo);
            List<Elemento> elementos = new ArrayList<>();
            for (PokemonElemento pe : pes){
                Elemento e = ServicosElemento.achar(pe.getIdElemento());
                elementos.add(e);
            }
            PokemonElementosDTO pesDTO = new PokemonElementosDTO();
            pesDTO.setElementos(elementos);
            pesDTO.setPokemon(p);
            return pesDTO;

    }

    public static List<PokedexDTO> listarPokedexDTO(){
        List<PokedexDTO> dtos = new ArrayList<PokedexDTO>();
        List<Pokedex> objs = daoPokedex.listarTodos();
        for (Pokedex obj : objs){
            PokedexDTO dto = new PokedexDTO();
            dto.setPokedex(obj);
            dto.setJogo(ServicosJogo.achar(obj.getIdJogo()));
            dto.setRegiao(ServicosRegiao.achar(obj.getIdRegiao()));
            dto.setPokemon(ServicosPokedex.montarPokemonElementoDTO(obj.getIdPokemon(), obj.getIdJogo()));
            dto.setAnte(ServicosPokedex.montarPokemonElementoDTO(obj.getIdAnterior(), obj.getIdJogo()));;
            dto.setProx(ServicosPokedex.montarPokemonElementoDTO(obj.getIdProximo(), obj.getIdJogo()));;
            dtos.add(dto);
        }
        return dtos;
    };
    
}
