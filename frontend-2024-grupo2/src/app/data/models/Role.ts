export type RoleJSON = {
  name: string
  isAdministrator: boolean
}

export class Role {
  constructor(
    public name: string,
    public isAdministrator: boolean
  ) {}

  static fromJSON(roleJSON: RoleJSON): Role {
    return Object.assign(new Role(roleJSON.name, roleJSON.isAdministrator))
  }

  toJSON(): RoleJSON {
    return {
      name: this.name,
      isAdministrator: this.isAdministrator
    }
  }
}
