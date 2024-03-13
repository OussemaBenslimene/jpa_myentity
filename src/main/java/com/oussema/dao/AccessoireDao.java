package com.oussema.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.oussema.entities.Accessoire;
import com.oussema.util.JPAutil;
//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class AccessoireDao {
private EntityManager entityManager=JPAutil.getEntityManager("JPA_MyEntity");
//méthode ajouter d'une entité à la bd
public void ajouter(Accessoire c)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(c);
tx.commit();
}
//méthode modifier d'une entité à partir de la bd
public void modifier(Accessoire c)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(c);
tx.commit();
}
//méthode Supprimer d'une entité à partir de la bd
public void supprimer(Accessoire c)
{
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
c=entityManager.merge(c); // important
entityManager.remove(c);
tx.commit();
}
//méthode Consulter d'une entité à partir de la bd
public Accessoire consulter(Accessoire c,Object id)
{
return entityManager.find(c.getClass(), id);
}
//méthode pour lister tous les objets à partir de la bd
public List<Accessoire> listerTous() {
List<Accessoire> Accessoires =
entityManager.createQuery(
"select c from Accessoire c").getResultList();

return Accessoires;
}
//méthode pour lister tous les Accessoire dont le nom contient un
//texte donné en paramètre (pnom)
public List<Accessoire> listerParReference(String ref) {List<Accessoire> Accessoires
=entityManager.createQuery( "select c from Accessoire c where c.ref like :pnom")
.setParameter("pnom","%"+ref+"%").getResultList();

return Accessoires; }}