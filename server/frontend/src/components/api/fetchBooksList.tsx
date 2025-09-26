import { QueryClient, QueryClientProvider, useQuery } from '@tanstack/react-query'
import Box from '@mui/material/Box';
import { type Book } from '../types';
import BookList  from '../BookList.tsx';
import { RingLoader } from "react-spinners";
import "../css/index.css"
import ErrorPage from "../pages/error.tsx"

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
    queryFn: () => fetch('/api/').then(res => res.json()),
    staleTime: Infinity
  })

  if (isLoading) return (
    <div className="mx-auto mt-10 flex items-center justify-center flex-row flex-column max-w-2xl border-t border-gray-200 pt-10 sm:mt-16 sm:pt-16 lg:mx-0 lg:max-w-none ">
      <RingLoader className="mt-30 self-center" color="var(--color-dark)" loading={isLoading} size={300} />
    </div>
  );
  
  //TODO: make this a redirect to a err page
  
  if (error) return <ErrorPage code={500} title="whoops!" description="It appears my there is a problem with the server. I am on it! ~ Mikolaj"/>;

  if (data === undefined) {
     return <ErrorPage code={500} title="whoops!" description="It appears my there is a problem with the server. I am on it! ~ Mikolaj"/>
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

