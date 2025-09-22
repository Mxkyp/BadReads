import React from "react";
import { motion } from "framer-motion";

export default function BookPage() {
  return (
    <QueryClientProvider client={queryClient}>
      <Fetch>15</Fetch>
    </QueryClientProvider>
  )
}


function Fetch(bookId) {
  const { isLoading, error, book} = useQuery('repoData', () =>
    fetch(`/api/book?id=${bookId}`).then(res =>
      res.json()
    )
  )

  if (isLoading) return 'Loading...'

  if (error) return 'An error has occurred: ' + error.message

  return (
    <div className="min-h-screen bg-gray-100 p-6 flex flex-col items-center">
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="bg-white shadow-xl rounded-2xl p-6 max-w-xl w-full"
        >
          <img
            src={book.metadata.thumbnailUrl}
            alt={book.metadata.title}
            className="w-full h-96 object-cover rounded-xl mb-4"
          />
          <h2 className="text-2xl font-bold text-gray-800 mb-2">
            {book.metadata.title}
          </h2>
          <p className="text-gray-600 mb-1">
            by {book.author.Name} {book.author.Surname}
          </p>
          <p className="text-sm text-gray-500 mb-4">
            Published: {book.metadata.publishedDate} | Pages: {book.metadata.pageNumber}
          </p>
          <p className="text-gray-700 mb-4">{book.metadata.description}</p>
          <div className="flex flex-wrap gap-2">
            {book.metadata.genres?.map((genre: string, idx: number) => (
              <span
                key={idx}
                className="text-xs px-2 py-1 bg-green-100 text-green-800 rounded-full"
              >
                {genre}
              </span>
            ))}
          </div>
        </motion.div>
    </div>
  );
}

BookPage.hydrate = true as const;
