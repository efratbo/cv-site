<script setup lang="ts">
import { RouterLink, RouterView, useRoute } from 'vue-router'

const route = useRoute()
</script>

<template>
<div>
    <nav class="bg-gray-800 p-4 rounded-lg shadow-md mb-4">
      <router-link 
        to="/" 
        class="text-white px-3 py-2 rounded hover:bg-gray-700"
        :class="{ 'bg-gray-900': route.path === '/' }"
      >Home</router-link>
      <router-link 
        to="/about" 
        class="text-white px-3 py-2 rounded hover:bg-gray-700"
        :class="{ 'bg-gray-900': route.path === '/about' }"
      >About</router-link>
      <router-link 
        to="/repositories" 
        class="text-white px-3 py-2 rounded hover:bg-gray-700"
        :class="{ 'bg-gray-900': route.path === '/repositories' }"
      >Repositories</router-link>
      <router-link 
        to="/following" 
        class="text-white px-3 py-2 rounded hover:bg-gray-700"
        :class="{ 'bg-gray-900': route.path === '/following' }"
      >Following</router-link>
    </nav>
    <router-view /> <!-- Display the matched route -->
  </div>
</template>

