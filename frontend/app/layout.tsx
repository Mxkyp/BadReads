"use client";
import type { Metadata } from "next";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";
import React, { useState } from "react";
import { BooksContext } from "@/lib/BooksContext";

export default function RootLayout({ children }: { children: React.ReactNode }) {
  const [books, setBooks] = useState([]);

  return (
    <html lang="en">
      <body>
        <BooksContext.Provider value={{ books, setBooks }}>
          {children}
        </BooksContext.Provider>
      </body>
    </html>
  );
}
