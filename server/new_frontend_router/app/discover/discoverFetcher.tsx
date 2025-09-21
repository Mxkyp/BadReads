import { QueryClient, QueryClientProvider, useQuery } from 'react-query'
import { motion } from "framer-motion";

const queryClient = new QueryClient()

export default function Fetcher() {
  return (
    <QueryClientProvider client={queryClient}>
      <Fetch />
    </QueryClientProvider>
  )
}

function Fetch() {
  const { isLoading, error, data } = useQuery('repoData', () =>
    fetch('/api/').then(res =>
      res.json()
    )
  )

  if (isLoading) return 'Loading...'

  if (error) return 'An error has occurred: ' + error.message

  return (
        <div className="mx-auto mt-10 grid max-w-2xl grid-cols-1 gap-x-8 gap-y-16 border-t border-gray-200 pt-10 sm:mt-16 sm:pt-16 lg:mx-0 lg:max-w-none lg:grid-cols-3">
          {data.map((book) => (

            <motion.div
              key={book.id}
              whileHover={{ scale: 1.05 }}
              className="cursor-pointer"
              onClick={() => navigate(`/book?id=${book.id}`)}
            >
            <article key={book.id} className="flex mx-5 max-w-xl flex-col p-8 items-start justify-between bg-white shadow rounded-2xl overflow-hidden">
              <img
                src={book.metadata.thumbnailURL}
                alt={book.metadata.title}
                className="w-auto h-85 object-cover rounded-xl mb-2 place-self-center"
              />
              <div className="flex items-center gap-x-4 text-xs">
                <a
                  href={book.metadata.subtitle}
                  className="relative z-10 rounded-full bg-gray-50 px-3 py-1.5 font-medium text-gray-600 hover:bg-gray-100"
                >
                  {book.metadata.genres[0]}
                </a>
              </div>
              <div className="group relative grow">
                <h3 className="mt-3 text-lg/6 font-semibold text-gray-900 group-hover:text-gray-600">
                  <a href={book.metadata.title}>
                    <span className="absolute inset-0" />
                    {book.metadata.title}
                  </a>
                </h3>
                {book.metadata.subtitle}
                <p className="mt-5 line-clamp-3 text-sm/6 text-gray-600">{book.metadata.description}</p>
              </div>
            </article>
            </motion.div>
          ))}
        </div>
  )
}
