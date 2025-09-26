import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import useMediaQuery from '@mui/material/useMediaQuery';
import { useTheme } from '@mui/material/styles';
import { Link } from "react-router";

export default function BookList({bookData}){
  const theme = useTheme();
  const sm = useMediaQuery(theme.breakpoints.between(0, "sm"));
  const md = useMediaQuery(theme.breakpoints.between("sm", "md"));
  const lg = useMediaQuery(theme.breakpoints.between("md", "lg"));

  let colNumber: number = sm ? 3 : md ? 6 : lg ? 8 : 10;
  const fallbackImage = 'https://i.redd.it/fzvkm8nipicz.jpg';

  return (
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
  )
}
