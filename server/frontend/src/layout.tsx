import React, { useState } from "react";
import "./globals.css";
import { BooksContext } from "./lib/BooksContext";

export default function RootLayout({ children }: { children: React.ReactNode }) {
  const [books, setBooks] = useState<any[]>([]);

  return (
    <BooksContext.Provider value={{ books, setBooks }}>
      {children}
    </BooksContext.Provider>
  );
}
