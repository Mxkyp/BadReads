import { defineConfig, loadEnv } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite'
// https://vite.dev/config/
export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd(), '')

  return {
    plugins: [react(), tailwindcss()],
    server: {
      port: 3000,
      host: '0.0.0.0',
      hmr: {
        host: env.VITE_SERVER_NAME,
        protocol: 'wss',
        port: 443
      },
      allowedHosts: [env.VITE_SERVER_NAME]
    }
  }
})

