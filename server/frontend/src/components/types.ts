export type Book = { 
  id: number; 
  author: {Name: string; Surname: string }; 
  metadata: { isbn13: string; isbn10: string;
              title: string; subtitle: string; 
            genres: string[]; thumbnailURL: string; 
            description: string; publishedYear:string; 
            averageRating: number } 
};
