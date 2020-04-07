import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Functional {
    private static final String PATH = "JPATest";
    private  EntityManagerFactory entityManagerFactory;
    public  EntityManager entityManager;


    public List<Menu> allMenu(){
        List<Menu> allMenu;
        TypedQuery<Menu> allMenuQuery = entityManager.createQuery("SELECT c FROM Menu c", Menu.class);
        allMenu = allMenuQuery.getResultList();
        return allMenu;
    }


    public List<Menu> saleMenuscostFromAndTo(int from, int befor){
        List<Menu> saleMenus;
        TypedQuery<Menu> saleMenuTypedQuery= entityManager.createQuery("SELECT c FROM Menu c WHERE c.price > :from AND c.price < :befor", Menu.class);
        saleMenuTypedQuery.setParameter("from", from);
        saleMenuTypedQuery.setParameter("befor", befor);

        saleMenus = saleMenuTypedQuery.getResultList();

        return saleMenus;
    }

    public List<SaleMenu> productsOnlySale(){
        List<SaleMenu> saleMenus;
        TypedQuery<SaleMenu> saleMenuTypedQuery= entityManager.createQuery("SELECT c FROM SaleMenu c WHERE c.sale > :prise", SaleMenu.class);
        saleMenuTypedQuery.setParameter("prise", 0);
        saleMenus = saleMenuTypedQuery.getResultList();
        return saleMenus;
    }

    public void printMenu(){
        Manager();
        saveProd(new Menu("Meat", 1200, 320));
        saveProd(new Menu("Fish", 1700, 280));
        saveProd(new Menu("Fish lime", 1900, 280));
        saveProd(new SaleMenu("Bear", 120,500,10));
        saveProd(new SaleMenu("Vodka", 99,50,10));
        saveProd(new Menu("Fish", 1700, 280));
        saveProd(new Menu("Fresh", 900, 320));
        saveProd(new SaleMenu("Wiski", 220,100,20));
        saveProd(new SaleMenu("Bograch", 2220,500,25));
    }

    public void saveProd(Menu menu){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(menu);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        }
    }
    public List<Menu> choiceOfDishesWeightOneKG(){
        List<Menu> menuList = allMenu();
        List<Menu> menu = new ArrayList<>();
        int weight = 0;
        for(;;){
            int random = (int)(Math.random()*menuList.size());
            weight = weight + menuList.get(random).height;
            if(weight < 1000) {
                menu.add(menuList.get(random));
            }
            else if(weight>1000){
                break;
            }
        }
        return menu;
    }


    public void Manager(){
        entityManagerFactory = Persistence.createEntityManagerFactory(PATH);
        entityManager = entityManagerFactory.createEntityManager();
    }
}
