package com.oussema.test;
import com.oussema.dao.AccessoireDao;
import com.oussema.entities.Accessoire;
public class AccessoireTest {
public static void main(String[] args) {
//créer un objet Accessoire
Accessoire c = new Accessoire();
c.setRef("Redragon Hydra");
c.setCategorie("Souris Gamer");
c.setPrix(250);
//ajouter l'objet Accessoire à la BD
AccessoireDao accDao = new AccessoireDao();
accDao.ajouter(c);
System.out.println("Appel de la méthode listerTous");
for (Accessoire cl : accDao.listerTous())
System.out.println(cl.getCode()+" "+cl.getRef()+" "+cl.getCategorie()+" "+cl.getPrix());
System.out.println("Appel de la méthode listerParNom");
for (Accessoire cl : accDao.listerParReference("red"))

System.out.println(cl.getCode()+" "+cl.getRef()+" "+cl.getCategorie()+" "+cl.getPrix());

//tester les autres méthodes de la classe AccessoireDao

}
}