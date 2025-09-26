import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router";

import LandingPage from './components/pages/landing.tsx'
import DiscoveryPage from './components/pages/discover.tsx'
import ErrorPage from './components/pages/error.tsx'
import LoginPage from './components/pages/login.tsx'

const router = createBrowserRouter([
  {path:"/", element:<LandingPage />},
  {path:"/discover", element:<DiscoveryPage/>},
  {path:"/login", element:<LoginPage />},
  {path:"*", element: <ErrorPage code={404} title={"page not found"} description={"Sorry, we couldn’t find the page you’re looking for."}/>}
]);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router}/>
  </StrictMode>,
)
