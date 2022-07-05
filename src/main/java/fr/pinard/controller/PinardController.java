package fr.pinard.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.pinard.model.Vin;
import fr.pinard.model.Vin.choix;
import fr.pinard.model.VinPK;
import fr.pinard.repository.VinRepository;

/**
 * @author Philippe
 *
 */
@RestController
@CrossOrigin("*")
public class PinardController {

	@Autowired
	private VinRepository vinRepository;

	@GetMapping("/accueil")
	@ResponseBody
	public String home(){
/*
		Vin v1=new Vin();
		VinPK pk1=new VinPK(777777,"Les Hauts du Tertre 2005");
		v1.setVinPK(pk1);
		v1.setRegion("Bordeaux (Margaux)");
		v1.setCouleur(choix.ROUGE);
		v1.setPrix(11.50);
		v1.setRemise(0);
		v1.setQuantite(2);

		Vin v2=new Vin();
		VinPK pk2=new VinPK(888888,"Château Marquis de Terme 1899");
		v2.setVinPK(pk2);
		v2.setRegion("Bordeaux (Margaux)");
		v2.setCouleur(choix.BLANC);
		v2.setPrix(19.00);
		v2.setRemise(0);
		v2.setQuantite(3);

		Vin v3=new Vin();
		VinPK pk3=new VinPK(999999,"Clos du Marquis 2007");
		v3.setVinPK(pk3);
		v3.setRegion("Bordeaux (Saint-Julien)");
		v3.setCouleur(choix.ROUGE);
		v3.setPrix(22.90);
		v3.setRemise(0);
		v3.setQuantite(15);

		Vin v4=new Vin();
		VinPK pk4=new VinPK(111111,"Clos du Baron 2015");
		v4.setVinPK(pk4);
		v4.setRegion("Bordeaux (Saint-Julien)");
		v4.setCouleur(choix.BLANC);
		v4.setPrix(45.20);
		v4.setRemise(0);
		v4.setQuantite(50);


		System.out.println("ajout du produit v1 : "+v1);
		ajoutVin(v1);

		System.out.println("ajout du produit v2 : "+v2);
		ajoutVin(v2);

		System.out.println("ajout du produit v3 : "+v3);
		v3=ajoutVin(v3);

		System.out.println("ajout du produit v4 : "+v4);
		v4=ajoutVin(v4);
*/
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>Regardez dans votre console et dans votre base de données MySQL <strong>JPA</strong></h1>");
		sb.append("<ul><li><a href='http://localhost:8080/vins'>Voir la liste des vins enregistrés</a></li>");
		sb.append("<li><a href='http://localhost:8080/swagger-ui/index.html'>Avec Swagger 3.0</a></li></ul>");
		return  sb.toString();
	}


	/**
	 * Recherche d'un vin par son identifiant et sa désignation
	 * @param id
	 * @param designation
	 * @return
	 */
	@GetMapping("/vin/{id}/{designation}")
	public Optional<Vin> findById(@PathVariable("id") Integer id, @PathVariable("designation") String designation){
		return vinRepository.findById(new VinPK(id, designation));
	}
	/**
	 * Retourne tous les vins stockés en BD
	 * @return collection de Vins
	 */
	@GetMapping("/vins")
	public Collection<Vin> findAll(){

		return vinRepository.findAll();
	}
	/**
	 * Ajoute un Vin en BD
	 * @param vin
	 * @return
	 */
	@PostMapping("/vin/post")
	public Vin ajoutVin(@RequestBody Vin vin){
		return vinRepository.save(vin);
	}
	/**
	 * Met à jour un Vin
	 * @param vin
	 * @return
	 */
	@PutMapping("/vin/put")
	public Vin updateVin(@RequestBody Vin vin){
		return vinRepository.save(vin);
	}


	/**
	 * Met à jour la quantité d'un Vin grâce à l'identifiant passé en paramètre
	 * @param id
	 * @param designation
	 * @param quantite
	 */
	@PutMapping("/vin/{id}/{designation}/{quantite}")
	public void updateQuantite(@PathVariable("id") Integer id,
			@PathVariable("designation") String designation,
			@PathVariable("quantite") int quantite){
		(vinRepository.getReferenceById(new VinPK(id, designation))).setQuantite(quantite);
	}


}
