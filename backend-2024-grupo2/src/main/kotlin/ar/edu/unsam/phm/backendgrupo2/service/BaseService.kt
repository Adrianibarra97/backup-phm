package ar.edu.unsam.phm.backendgrupo2.service

interface BaseService<T> {

  fun getAll(): List<T>

  fun getOneById(objectId: Int): T

  fun create(anObject: T)

  fun update(anObject: T)

  fun delete(anObject: T)
}