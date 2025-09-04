<script setup lang="ts">
import type { UserDto } from '../types/GithubTypes.ts'

const props = defineProps<{ user: UserDto }>()
</script>

<template>
  <div class="shadow-md rounded-lg p-4 w-64 border border-gray-300">
    <img
      :src="`https://github.com/${props.user.login}.png`"
      alt="Avatar"
      class="w-16 h-16 rounded-full mx-auto mb-4"
    />
    <a
      :href="props.user.url"
      class="text-xl font-semibold text-center text-blue-500 hover:underline block text-center"
      >{{ props.user.name }}</a
    >
    <p class="text-center text-white-600">{{ props.user.updatedAt }}</p>

    <p
      class="text-center text-white-600 bg-blue-100 text-blue-800 rounded-full px-3 py-1 my-2 w-32 mx-auto"
    >
      Followers: {{ props.user.followers }}
    </p>
    <p
      class="text-center text-white-600 bg-green-100 text-green-800 rounded-full px-3 py-1 my-2 w-32 mx-auto"
    >
      Following: {{ props.user.following }}
    </p>

    <p class="text-center text-white-600">{{ props.user.blog }}</p>
    <p class="text-center text-white-600">{{ props.user.email }}</p>
    <p class="text-center text-white-600">{{ props.user.company }}</p>
    <p class="text-center text-white-600">{{ props.user.location }}</p>
    <p class="text-center text-white-600">{{ props.user.bio }}</p>
  </div>
</template>
