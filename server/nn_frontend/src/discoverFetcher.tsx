import { QueryClient, QueryClientProvider, useQuery } from '@tanstack/react-query'
import Box from '@mui/material/Box';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';

const queryClient = new QueryClient()

export default function Fetcher() {
  return (
    <QueryClientProvider client={queryClient}>
      <Fetch />
    </QueryClientProvider>
  )
}

type Book = { 
  id: number; 
  author: {Name: string; Surname: string }; 
  metadata: { isbn13: string; isbn10: string;
              title: string; subtitle: string; 
            genres: string[]; thumbnailURL: string; 
            description: string; publishedYear:string; 
            averageRating: number } 
};

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
  return (
    <div className="mx-auto mt-10 flex max-w-2xl justify-items-center border-t border-gray-200 pt-10 sm:mt-16 sm:pt-16 lg:mx-0 lg:max-w-none ">
      <Box sx={{ overflowY: 'scroll' }}>
        <ImageList variant="masonry" cols={8} gap={8}>
          {bookData.map((book: Book) => (
            <ImageListItem key={book.id}>
              <img
                className="hover:scale-105 transition duration-400"
                srcSet={`${book.metadata.thumbnailURL}?w=248&fit=crop&auto=format&dpr=2 2x`}
                src={`${book.metadata.thumbnailURL}?w=248&fit=crop&auto=format`}
                alt={book.metadata.title}
                loading="lazy"
              />
            </ImageListItem>
          ))}
        </ImageList>
      </Box>
    </div>
  )
}

