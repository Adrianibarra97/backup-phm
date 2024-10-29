export interface BaseService<T> {
  getAll(): Promise<T[]>

  getOneById(id: number): Promise<T>

  create(object: T): Promise<void>

  update(object: T): Promise<void>

  delete(id: number): Promise<void>
}
