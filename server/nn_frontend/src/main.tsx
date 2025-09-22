import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.tsx'
import DiscoveryPage from './discoverPage.tsx'
import { createBrowserRouter, RouterProvider } from "react-router";

const router = createBrowserRouter([
  {path:"/", element:<App/>},
  {path:"/discover", element:<DiscoveryPage/>},
]);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router}/>
  </StrictMode>,
)
