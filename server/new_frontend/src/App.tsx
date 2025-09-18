import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import LandingPage from './components/LandingPage.tsx'
import DiscoverBooksPage from './components/DiscoverBooksPage.tsx'
function App() {

  return (
    <>
    <LandingPage></LandingPage>
    <DiscoverBooksPage></DiscoverBooksPage>
    </>
  )
}

export default App
