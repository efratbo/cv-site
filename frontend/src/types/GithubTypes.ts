// Repository DTO TypeScript Interface
export interface RepositoryDto {
  nodeId: string
  name: string
  description: string | null
  homepage: string | null
  fork: boolean
  archived: boolean
  visibility: string
  size: number
  language: string | null
  isTemplate: boolean
  url: string
  id: number
  createdAt: string
  updatedAt: string
  stars: number
  markdown: string | null
}

// User DTO TypeScript Interface
export interface UserDto {
  login: string
  name: string
  location: string | null
  blog: string | null
  email: string | null
  bio: string | null
  company: string | null
  type: string
  followers: number
  following: number
  hireable: boolean
  url: string
  id: number
  nodeId: string
  createdAt: string
  updatedAt: string
}
