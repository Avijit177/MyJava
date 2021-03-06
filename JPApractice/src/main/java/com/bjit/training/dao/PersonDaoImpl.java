package com.bjit.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bjit.training.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

 @PersistenceContext
 private EntityManager em;

 public void add(Person person) {
  em.persist(person);
 }

 public List<Person> listPersons() {
  CriteriaQuery<Person> criteriaQuery = em.getCriteriaBuilder().createQuery(Person.class);
  @SuppressWarnings("unused")
  Root<Person> root = criteriaQuery.from(Person.class);
  return em.createQuery(criteriaQuery).getResultList();
 }

}