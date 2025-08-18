import { createBrowserRouter, RouterProvider } from "react-router-dom";
import React, { useState } from "react";
import ReactDOM from "react-dom/client";
import './globals.css';
import GoodreadsCloneLanding from "./page.tsx";
import BookPage from "./book/page.tsx"; 
import { BooksContext } from "./lib/BooksContext";

export default function App() {
  const [books, setBooks] = useState<any[]>([]);

  const router = createBrowserRouter([
    { path: "/", element: <GoodreadsCloneLanding /> },
    { path: "/book", element: <BookPage /> },
  ]);

  return (
    <BooksContext.Provider value={{ books, setBooks }}>
      <RouterProvider router={router} />
    </BooksContext.Provider>
  );
}

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
