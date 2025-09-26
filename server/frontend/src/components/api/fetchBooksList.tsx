import { QueryClient, QueryClientProvider, useQuery } from '@tanstack/react-query'
import Box from '@mui/material/Box';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import { type Book } from '../types'
import { Link } from "react-router";
import { useTheme } from '@mui/material/styles';
import useMediaQuery from '@mui/material/useMediaQuery';

const queryClient = new QueryClient();

export default function FetchBookList() {
  
  return (
    <QueryClientProvider client={queryClient}>
      <Fetch />
    </QueryClientProvider>
  )
}

function Fetch() {
  const theme = useTheme();
  const sm = useMediaQuery(theme.breakpoints.between(0, "sm"));
  const md = useMediaQuery(theme.breakpoints.between("sm", "md"));
  const lg = useMediaQuery(theme.breakpoints.between("md", "lg"));

  const { isLoading, error, data} = useQuery({
    queryKey: ['repoData'],
    queryFn: () => fetch('http://localhost:8080/').then(res => res.json()),
    staleTime: Infinity
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
  let colNumber: number = sm ? 3 : md ? 6 : lg ? 8 : 10;
  let fallbackImage = 'https://i.redd.it/fzvkm8nipicz.jpg';
  return (
    <div className="mx-auto mt-10 flex flex-row max-w-2xl border-t border-gray-200 pt-10 sm:mt-16 sm:pt-16 lg:mx-0 lg:max-w-none ">
      <Box className="grow" sx={{ overflowY: 'scroll' }}>
        <ImageList variant="masonry" cols={colNumber} gap={8}>
          {bookData.map((book: Book) => (
            <Link to={"./book/" + book.id}>
            <ImageListItem key={book.id}>
              <img
                className="hover:scale-105 transition duration-400"
                srcSet={
                    book.metadata?.thumbnailURL
                      ? `${book.metadata.thumbnailURL.replace(/^http:\/\//i, "https://")}?w=248&fit=crop&auto=format&dpr=2 2x`
                      : `${fallbackImage}?w=248&fit=crop&auto=format2x`
                  }
                  src={
                    book.metadata?.thumbnailURL
                      ? `${book.metadata.thumbnailURL.replace(/^http:\/\//i, "https://")}?w=248&fit=crop&auto=format`
                      : `${fallbackImage}?w=248&fit=crop&auto=format2x` 
                  }
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

