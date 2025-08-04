"use client";
import React, { useEffect, useState } from "react";
import { Card, CardContent } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { motion } from "framer-motion";

export default function GoodreadsCloneLanding() {
  const [books, setBooks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/") // Replace with your actual endpoint
      .then((res) => {
        if (!res.ok) throw new Error("Failed to fetch books");
        return res.json();
      })
      .then((data) => setBooks(data))
      .catch((err) => setError(err.message))
      .finally(() => setLoading(false));
  }, []);

  return (
    <div className="min-h-screen bg-gray-100 p-6">
      <header className="flex flex-col items-center justify-center mb-10">
        <motion.h1
          className="text-4xl font-bold text-green-800"
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
        >
          Welcome to BookVerse
        </motion.h1>
        <p className="text-gray-600 mt-2">Discover, rate, and review books</p>
        <div className="mt-4 flex gap-2">
          <Input type="text" placeholder="Search for books..." className="w-64" />
          <Button>Search</Button>
        </div>
      </header>

      {loading ? (
        <p className="text-center">Loading books...</p>
      ) : error ? (
        <p className="text-center text-red-600">{error}</p>
      ) : (
        <motion.div
          className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 gap-4"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
        >
          {books.map((book) => (
            <Card key={book.id} className="bg-white shadow rounded-2xl overflow-hidden">
                <CardContent className="p-2 flex flex-col items-center">
                  <img
                    src={book.details.thumbnailUrl}
                    alt={book.details.title}
                    className="w-full h-64 object-cover rounded-xl mb-2"
                  />
                  <h3 className="font-semibold text-center text-md text-gray-800">
                    {book.details.title}
                  </h3>
                  <p className="text-sm text-gray-600">
                    by {book.details.author.Name} {book.details.author.Surname}
                  </p>
                </CardContent>
              </Card>
          ))}
        </motion.div>
      )}
    </div>
  );
}
