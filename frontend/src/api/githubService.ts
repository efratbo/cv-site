import axios from 'axios'

import type { RepositoryDto, UserDto } from '../types/GithubTypes.ts'

const BASE_URL = import.meta.env.VITE_BACKEND_URL+"/portfolio"
// Fetch repositories
export const fetchMyRepos = async (): Promise<RepositoryDto[]> => {
  const response = await axios.get(`${BASE_URL}/my-repos`)
  return response.data
}

// Fetch user details
export const fetchMyself = async (): Promise<UserDto> => {
  const response = await axios.get(`${BASE_URL}/myself`)
  return response.data
}

// Fetch following users
export const fetchFollowingUsers = async (): Promise<UserDto[]> => {
  const response = await axios.get(`${BASE_URL}/following`)
  return response.data
}
