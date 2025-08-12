"use client";

import React, { useEffect, useState } from "react";
import { useSearchParams } from "next/navigation";
import { motion } from "framer-motion";
import { Button } from "@/components/ui/button";
import ErrorPage from "@/components/ErrorPage";

export default function BookDetailsPage() {
  const searchParams = useSearchParams();
  const bookId = searchParams.get("id");
  const [book, setBook] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

useEffect(() => {
  if (!bookId) return;

  fetch(`http://localhost:8080/book?id=${bookId}`)
    .then(async (res) => {
      if (!res.ok) {
        const errData = await res.json();
        throw { status: errData.status, message: errData.message };
      }
      return res.json();
    })
    .then((data) => setBook(data))
    .catch((err) => setError(err))
    .finally(() => setLoading(false));
}, [bookId]);

  if (!bookId) return <p className="text-center mt-10">No book ID provided.</p>;

  return (
    <div className="min-h-screen bg-gray-100 p-6 flex flex-col items-center">
      {loading ? (
        <p>Loading book details...</p>
        ) : error ? (
          <ErrorPage code={error.status} message={error.message} />
        ) : book ? (
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="bg-white shadow-xl rounded-2xl p-6 max-w-xl w-full"
        >
          <img
            src={book.details.thumbnailUrl}
            alt={book.details.title}
            className="w-full h-96 object-cover rounded-xl mb-4"
          />
          <h2 className="text-2xl font-bold text-gray-800 mb-2">
            {book.details.title}
          </h2>
          <p className="text-gray-600 mb-1">
            by {book.details.author.Name} {book.details.author.Surname}
          </p>
          <p className="text-sm text-gray-500 mb-4">
            Published: {book.details.publishedDate} | Pages: {book.details.pageNumber}
          </p>
          <p className="text-gray-700 mb-4">
            {book.details.description}
          </p>
          <div className="flex flex-wrap gap-2">
            {book.details.genres?.map((genre, idx) => (
              <span
                key={idx}
                className="text-xs px-2 py-1 bg-green-100 text-green-800 rounded-full"
              >
                {genre}
              </span>
            ))}
          </div>
        </motion.div>
      ) : null}

      <Button onClick={() => window.history.back()} className="mt-6">
        ← Back
      </Button>
    </div>
  );
}
