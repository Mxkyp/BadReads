import { QueryClient, QueryClientProvider, useQuery } from '@tanstack/react-query'
import Box from '@mui/material/Box';
import { type Book } from '../types';
import BookList  from '../BookList.tsx';

const queryClient = new QueryClient();

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

  return (
    <div className="mx-auto mt-10 flex flex-row max-w-2xl border-t border-gray-200 pt-10 sm:mt-16 sm:pt-16 lg:mx-0 lg:max-w-none ">
      <Box className="grow" sx={{ overflowY: 'scroll' }}>
        <BookList bookData={bookData}/>
      </Box>
    </div>
  )
}

