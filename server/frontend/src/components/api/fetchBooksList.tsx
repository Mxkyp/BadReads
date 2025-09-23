import { QueryClient, QueryClientProvider, useQuery } from '@tanstack/react-query'
import Box from '@mui/material/Box';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import { type Book } from '../types'
import { Link } from "react-router";

const queryClient = new QueryClient()

export default function FetchBookList() {
  return (
    <QueryClientProvider client={queryClient}>
      <Fetch />
    </QueryClientProvider>
  )
}

function Fetch() {
  const { isLoading, error, data} = useQuery({
    queryKey: ['repoData'],
    queryFn: () => fetch('/api/').then(res => res.json()),
  })

  if (isLoading) return 'Loading...'

  if (error) return 'An error has occurred: ' + error.message

  //TODO: proper err handling
  if (data === undefined) {
    return "error reading data"
  }

  let bookData: Book[] = data;
  //TODO: Add variable number of columns based on screen size
  //TODO: Seperate bookList into a seperate component
  return (
    <div className="mx-auto mt-10 flex flex-row max-w-2xl border-t border-gray-200 pt-10 sm:mt-16 sm:pt-16 lg:mx-0 lg:max-w-none ">
      <Box className="grow" sx={{ overflowY: 'scroll' }}>
        <ImageList variant="masonry" cols={8} gap={8}>
          {bookData.map((book: Book) => (
            <Link to={"./book/" + book.id}>
            <ImageListItem key={book.id}>
              <img
                className="hover:scale-105 transition duration-400"
                srcSet={`${book.metadata.thumbnailURL}?w=248&fit=crop&auto=format&dpr=2 2x`}
                src={`${book.metadata.thumbnailURL}?w=248&fit=crop&auto=format`}
                alt={book.metadata.title}
                loading="lazy"
              />
            </ImageListItem>
            </Link>
          ))}
        </ImageList>
      </Box>
    </div>
  )
}

